import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

class SpeakableTest {

    @Test
    void test() {
//        sol2(5);
        solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
    }

    private String[] orders;
    private Set<Integer> course;
    private Map<Integer, List<String>> result = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        this.orders = new String[orders.length];
        for(int i=0; i < orders.length; i++) {
            this.orders[i] = sortString(orders[i]);
        }
        this.course = Arrays.stream(course).boxed().collect(Collectors.toSet());

        dfs(orders, new StringBuilder());
        return new String[0];
    }

    private String sortString(String value) {
        return value.chars().sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private void dfs(String[] orders, StringBuilder selectedFoods) {
        int length = selectedFoods.length();
        if(this.course.contains(length)) {
            List<String> foods = this.result.getOrDefault(length, new ArrayList<>());
            if(foods.isEmpty()) {
                foods.add(selectedFoods.toString());
                this.result.put(length, foods);
                return;
            }

            if(length > foods.get(0).length()) {
                foods.remove(length);
                foods.add()
            }
        }
    }
}
