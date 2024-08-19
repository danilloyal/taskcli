# TaskCLI

My solution for the [task-tracker](https://roadmap.sh/projects/task-tracker) from [roadmap.sh](https://roadmap.sh/) using Java.

## Project Details
- Build Tool: [Maven](https://maven.apache.org/download.cgi)
- Serialization/Deserialization: [Gson](https://google.github.io/gson/)
- Packaging: [Maven Shade Plugin](https://maven.apache.org/plugins/maven-shade-plugin/)

## How to Run

Clone the repository and run the following command:

```bash
git clone https://github.com/danilloyal/taskcli.git
```

Run the following command to build the project, ensure you have Maven installed:
```bash
mvn clean package
```

Run the following commands to run the application:
```bash
# Adding a new task
java -jar target/task-cli-1.0.jar add "Buy groceries"

# Updating and deleting tasks
java -jar target/task-cli-1.0.jar update 1 "Buy groceries and cook dinner"
java -jar target/task-cli-1.0.jar delete 1

# Marking a task as in progress or done
java -jar target/task-cli-1.0.jar mark-in-progress 1
java -jar target/task-cli-1.0.jar mark-done 1

# Listing all tasks
java -jar target/task-cli-1.0.jar list

# Listing tasks by status
java -jar target/task-cli-1.0.jar list done
java -jar target/task-cli-1.0.jar list todo
java -jar target/task-cli-1.0.jar list in-progress
```

On the first run, a JSON file named task.json will be created in your current directory. This file will store all task data, and subsequent modifications will be saved to this file.
