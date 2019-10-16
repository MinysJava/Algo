package Lesson_3;

public class Expreesion {
    private String exp;

    public Expreesion(String exp) {
        this.exp = exp;
    }

    public boolean cheakBracket(){
        MyStack<Character> stack = new MyStack<>(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else if (ch == ')' || ch == ']' || ch == '}'){
                if ((stack.isEmpty())){
                    System.out.println("Error in " + i + " position");
                    return false;
                }
                char top = stack.pop();
                if(ch == ')' && top != '(' || ch == ']' && top != '[' || ch == '}' && top != '{'){
                    System.out.println("Error in " + i + " position: bracket fail");
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            System.out.println("Error in position: bracket fail");
            return false;
        }
        return true;
    }
}
