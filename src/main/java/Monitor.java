import event.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Monitor {
    private Map<String, String> data;

    public Monitor(Map<String, String> data){
        this.data = data;
    }

    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException ignore) {
            // handle the exception
        }
        return null;
    }

    private Set<Class> findAllClasses(String packageName){
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }


    public Event identifyEvent(){
        String eventClassFullPath = Event.class.getCanonicalName();
        String packageName = parsePackageName(eventClassFullPath);
        Set<Class> allEventClasses = findAllClasses(packageName);

        for (Class eventClass: allEventClasses){
            if(eventClassFullPath.equals(eventClass.getName())){
                continue;
            }

            try {
                Event event = (Event) eventClass.getDeclaredConstructor(Map.class).newInstance(this.data);
                if (event.is_accept_condition()){
                    return event;
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        return new UnknownEvent(this.data);
    }

    private String parsePackageName(String classFullPath){
        int splitIdx = classFullPath.lastIndexOf(".");
        return classFullPath.substring(0, splitIdx);
    }
}

