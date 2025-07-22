package sideproject.todoList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        manager.loadTasksFromFile();
        while (true) {
            System.out.println("\n📋 To-Do List");
            System.out.println("1. 할 일 추가");
            System.out.println("2. 할 일 목록 보기");
            System.out.println("3. 할 일 삭제");
            System.out.println("4. 할 일 완료 표시");
            System.out.println("5. 할 일 수정");
            System.out.println("0. 종료");
            System.out.print("선택 > ");

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    System.out.print("할일을 입력하세요: ");
                    String task = sc.nextLine();
                    manager.addTask(task);
                    break;
                case "2":
                    manager.printTasks();
                    break;
                case "3":
                    System.out.print("삭제할 번호를 입력하세요: ");
                    int delIndex = Integer.parseInt(sc.nextLine()) - 1;
                    manager.removeTask(delIndex);
                    break;
                case "4":
                    System.out.print("완료할 번호를 입력하세요: ");
                    int doneIndex = Integer.parseInt(sc.nextLine()) - 1;
                    manager.markTask(doneIndex);
                    break;
                case "5":
                    System.out.println("수정할 할일의 번호를 입력하세요: ");
                    int editIndex = Integer.parseInt(sc.nextLine()) - 1;
                    System.out.print("새로운 내용을 입력하세요: ");
                    String newDesc = sc.nextLine();
                    manager.updateTaskDescription(editIndex, newDesc);
                    break;
                case "0":
                    manager.saveTasksToFile();
                    System.out.println("저장완료. 프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
