package sideproject.todoList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> taskList = new ArrayList<>();
    private final String FILE_NAME = "tasks.txt";
//    생성
    public void addTask(String description){
        Task task = new Task(description);
        taskList.add(task);
    }
//    모든 할일 출력
    public void printTasks(){
        if (taskList.isEmpty()){
            System.out.println("할 일이 없습니다.");
            return;
        }
        for (int i = 0; i < taskList.size(); i++){
            System.out.println((i+1)+"."+taskList.get(i));
        }
    }
//    삭제
    public void removeTask(int index){
        taskList.remove(index);
    }
//    완료처리(마크다운)
    public void markTask(int index){
        if (index >= 0 && index < taskList.size()){
            taskList.get(index).markDone();
        }else {
            System.out.println("잘못된 번호 입니다.");
        }
    }
//    할일 수정
    public void updateTaskDescription(int index, String newDescription){
        if (index >= 0 && index < taskList.size()){
            taskList.get(index).setDescription(newDescription);
        }
    }

    public void saveTasksToFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : taskList){
                writer.write(task.toString());
                writer.newLine();
            }
            System.out.println("목록이 저장되었습니다.");
        }catch (IOException e){
            System.out.println("파일 저장 중 오류발생: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                boolean isDone = line.startsWith("[x]");
                String description = line.substring(3).trim(); // [ ] 또는 [x] 이후 텍스트

                Task task = new Task(description);
                if (isDone) {
                    task.markDone();
                }
                taskList.add(task);
            }
            System.out.println("할 일 목록을 불러왔습니다.");
        } catch (IOException e) {
            System.out.println("불러올 파일이 없거나 오류가 발생했습니다: " + e.getMessage());
        }
    }

}
