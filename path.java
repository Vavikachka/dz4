
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class path {
    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(path));
    }

    public static StringBuilder simplifyPath(String path) {
        StringBuilder newPath = new StringBuilder(); // записываем ответ
        Deque<String> ds = new ArrayDeque<>();
        String[] tokens = path.split("/"); // массив
        System.out.println(Arrays.toString(tokens));

        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "":
                    break;
                case ".":
                    break;
                case "..":
                    ds.pollLast();
                    break;
                default:
                    ds.add(tokens[i]);
                    break;
            }
        }
        System.out.println();
        while (!ds.isEmpty()) {
            newPath.append("/");
            newPath.append(ds.pop());
        }

        return newPath;
    }
}
