import static java.lang.Integer.parseInt;

public class TaskCLI {
    public static void main(String[] args) {
        String operation = "";
        if(args.length > 0){
            operation = args[0];
        }
        
        TaskManager manager = new TaskManager();

        switch(operation){
            case "add":
                if(args.length > 1) {
                    manager.addTask(args[1]);
                }else{
                    System.out.println("<description> value is required");
                }
                break;
            case "update":
                if(args.length > 2) {
                    int id = parseInt(args[1]);
                    manager.updateTask(id, args[2]);
                }else{
                    System.out.println("<new-description> value is required");
                }
                break;
            case "delete":
                if(args.length > 1){
                    int id = parseInt(args[1]);
                    manager.deleteTask(id);
                }else{
                    System.out.println("<task-id> is required");
                }
                break;
            case "mark-in-progress":
                if(args.length > 1){
                    int id = parseInt(args[1]);
                    manager.markInProgress(id);
                }else{
                    System.out.println("<task-id> is required");
                }
                break;
            case "mark-done":
                if(args.length > 1){
                    int id = parseInt(args[1]);
                    manager.markDone(id);
                }else{
                    System.out.println("<task-id> is required");
                }
                break;
            case "list":
                if(args.length > 1){
                    manager.listTasks(args[1]);
                }else{
                    manager.listTasks(null);
                }
                break;
            default:
                System.out.println("Command not valid");
                break;
        }
    }
}
