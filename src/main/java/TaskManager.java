import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class TaskManager {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static List<Task> tasks = new ArrayList<>();
        private static final String filePath = "task.json";

    public TaskManager(){
        File file = new File(filePath);
        loadfile(file);
    }

    public static void loadfile(File file){
        if(!file.exists()){
            try{
                FileWriter fw = new FileWriter(filePath);
                fw.write("[]");
                fw.close();
            }catch(Exception e){e.printStackTrace();}
            return;
        }
        Type listType = new TypeToken<List<Task>>(){}.getType();
        try{
            tasks = gson.fromJson(new FileReader(filePath), listType);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void saveFile(){
        try {
            FileWriter fw = new FileWriter(filePath);
            gson.toJson(tasks, fw);
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addTask(String description){
        Task task0 = new Task(tasks.size() + 1, description);
        tasks.add(task0);
        saveFile();
    }
    public void updateTask(int id, String description){
        boolean found = false;
        for(Task task : tasks){
            if(task.getId() == id){
                found = true;
                task.setDescription(description);
                task.setUpdatedAt(LocalDate.now().toString());
                saveFile();
                break;
            }
        }
        if(!found) System.out.println("id not found");
    }
    public void deleteTask(int id){
        boolean found = false;
        for(Task task : tasks){
            if(task.getId() == id){
                found = true;
                tasks.remove(task);
                saveFile();
                break;
            }
        }
        if(!found) System.out.println("id not found");
    }
    public void markInProgress(int id){
        boolean found = false;
        for(Task task : tasks){
            if(task.getId() == id){
                found = true;
                task.setStatus("in-progress");
                saveFile();
                break;
            }
        }
        if(!found) System.out.println("id not found");
    }
    public void markDone(int id){
        boolean found = false;
        for(Task task : tasks){
            if(task.getId() == id){
                found = true;
                task.setStatus("done");
                saveFile();
                break;
            }
        }
        if(!found) System.out.println("id not found");
    }
    public void listTasks(String status){
        tasks.stream()
                .filter(task -> status == null || Objects.equals(task.getStatus(), status))
                .map(Task::toString)
                .forEach(System.out::println);
    }
}

