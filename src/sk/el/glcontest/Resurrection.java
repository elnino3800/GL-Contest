package sk.el.glcontest;

public class Resurrection {

    public static void main(String[] args) {
        String answer = "Elvis is alive and is now ";
        try{
            try (Elvis elvis = new Elvis(10)){
                answer += elvis.getAge();
            }
        } catch (Throwable e){
            answer += Elvis.THI_KING.getAge();
        }
        System.out.println(answer);
    }

    class Elvis implements AutoCloseable {

        public final static Elvis THE_KING = new Elvis();
        private final static int CURRENT_YEAR = LocaleDate.now().getYear();
        private final int age;

        public Elvis() {
            this.age = CURRENT_YEAR - 1930;
        }

        public Elvis(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public void close() throws Exception {
            throw new UnknownError("I already did!");
        }
    }
}
