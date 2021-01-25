package opdrachten;

public class Opdracht1Npe {
    public static void main(String[] args) {
        ClassA cA = new ClassA(new ClassB(new ClassC(null)));
        cA.getClassB().getClassC().getClassD().doSomething();
        // TODO: Draai deze code met java 11 en een keer met java 14 en bekijk het verschil
    }

    private static class ClassA{
        private ClassB classB;

        public ClassA(ClassB classB) {
            this.classB = classB;
        }

        public ClassB getClassB() {
            return classB;
        }

        public void setClassB(ClassB classB) {
            this.classB = classB;
        }
    }

    private static class ClassB{
        private ClassC classC;

        public ClassB(ClassC classC) {
            this.classC = classC;
        }

        public ClassC getClassC() {
            return classC;
        }

        public void setClassC(ClassC classC) {
            this.classC = classC;
        }
    }

    private static class ClassC{
        private ClassD classD;

        public ClassC(ClassD classD) {
            this.classD = classD;
        }

        public ClassD getClassD() {
            return classD;
        }

        public void setClassD(ClassD classD) {
            this.classD = classD;
        }
    }

    private static class ClassD{
        public void doSomething() {
            System.out.println("Hello there");
        }
    }
}
