public class Ex07 {

    public static void main(String[] args) {

        // 속도가 빠르다...
        // 안녕하세요...asdf...속도차이가없으니깐
        // String... 사용하시면 됩니다...
        // 1000 + 1000 반복.. 100

        StringBuilder sb = new StringBuilder();
        sb.append("asdf");
        sb.append("asdf");

        System.out.println(sb);

        sb.delete(0,2);
        System.out.println(sb);

        sb.replace(0,5,"kkk");
        System.out.println(sb);

        sb.append("asdf");
        sb.reverse();
        System.out.println(sb);

        String aa = String.valueOf(sb);

        System.out.println(aa);

    }

}
