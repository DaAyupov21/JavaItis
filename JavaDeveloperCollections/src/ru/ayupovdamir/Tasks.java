package ru.ayupovdamir;

import java.util.*;

public class Tasks {

    public static void main(String[] args) {
        String randomText = "Задача организации, в особенности же социально-экономическое развитие создаёт предпосылки" +
                " качественно новых шагов для соответствующих условий активизации! Дорогие друзья, рамки и место" +
                " обучения кадров способствует подготовке и реализации дальнейших направлений развитая системы " +
                "массового участия. Значимость этих проблем настолько очевидна, что начало повседневной работы" +
                " по формированию позиции влечет за собой процесс внедрения и модернизации направлений прогрессивного " +
                "развития.\n" +
                "\n" +
                "Таким образом, постоянное информационно-техническое обеспечение нашей деятельности позволяет " +
                "оценить значение направлений прогрессивного развития? Разнообразный и богатый опыт сложившаяся " +
                "структура организации играет важную роль в формировании системы масштабного изменения ряда параметров!" +
                " Не следует, однако, забывать о том, что сложившаяся структура организации обеспечивает широкому кругу " +
                "специалистов участие в формировании системы обучения кадров, соответствующей насущным потребностям. " +
                "Соображения высшего порядка, а также выбранный нами инновационный путь требует определения и " +
                "уточнения ключевых компонентов планируемого обновления.\n" +
                "\n" +
                "Повседневная практика показывает, что реализация намеченного плана развития позволяет оценить " +
                "значение позиций, занимаемых участниками в отношении поставленных задач? С другой стороны сложившаяся" +
                " структура организации в значительной степени обуславливает создание форм воздействия. Практический" +
                " опыт показывает, что новая модель организационной деятельности требует от нас анализа системы " +
                "обучения кадров, соответствующей насущным потребностям! Разнообразный и богатый опыт дальнейшее " +
                "развитие различных форм деятельности создаёт предпосылки качественно новых шагов для ключевых " +
                "компонентов планируемого обновления!";
       /* Map<Character, Integer> frequencyMap = getFrequencyOfTextCharacter(randomText);

        List<String> listTOClear = List.of("Павел", "Алексей", "Анна","Иван", "Анна", "Евгений", "Анна");
        Collection<String> clearedCollection = clearCollectionFromDuplicateElements(listTOClear);
        System.out.println(clearedCollection);*/

        testTimeOfDifferentListImplementations();
    }

    private static void testTimeOfDifferentListImplementations() {

        List<Integer> integerArrayList = new ArrayList<>();
        List<Integer> integerLinkedList = new LinkedList<>();
        Random random = new Random();
        int size = 10000000;
        int attemptCount = 100000;
        for (int i = 0; i < size; i++) {
            integerArrayList.add(random.nextInt(size));
            integerLinkedList.add(random.nextInt(size));
        }

        long timeStart= System.nanoTime();
        for(int i = 0; i < attemptCount; i++){
            integerArrayList.get((int) (Math.random() * (size - 1)));
        }
        long timeEnd = System.nanoTime();
        System.out.println("For array list " + (timeEnd - timeStart));

        timeStart= System.nanoTime();
        for(int i = 0; i < attemptCount; i++){
            integerLinkedList.get((int) (Math.random() * (size - 1)));
        }
        timeEnd = System.nanoTime();
        System.out.println("For linked list " + (timeEnd - timeStart));
    }

    private static Collection<String> clearCollectionFromDuplicateElements(List<String> listTOClear) {
       return new HashSet<>(listTOClear);
    }

    private static Map<Character, Integer> getFrequencyOfTextCharacter(String randomText) {
        Integer pointer = null;
        Map<Character, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < randomText.length(); i++){
            Character character = randomText.charAt(i);
            if ((pointer = resultMap.get(character)) != null){
                resultMap.put(character, ++pointer);
            }
            else {
                resultMap.put(character, 1);
            }
        }
        return resultMap;
    }
}
