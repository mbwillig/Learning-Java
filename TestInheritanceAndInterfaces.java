

class TestInheritanceAndInterfaces {

    /*  tests inheritance Phase -> (Solid, Liquid) and an interface (Shiny)*/

    abstract class Phase {
        double density;

        double getDensity() {
            return this.density;
        }
    }

    abstract class Solid extends Phase{
        int hardness;

        int getHardness() {
            return this.hardness;
        }
    }

    abstract class Liquid extends Phase{
            double viscosity;

        double getViscosity() {
            return this.viscosity;
        }
    }

    interface Shiny{
        void lookAtReflection();
    }


    class Granite extends Solid{
        Granite(){
            this.density = 2.7;
            this.hardness = 6;
        }
    }

    class IronNickelMeteorite extends Solid implements Shiny{
        IronNickelMeteorite(){
            this.density = 2.7;
            this.hardness = 7;
        }

        public void lookAtReflection() {
            System.out.println("your face looks extra spacey in this chunk of extraterrestrial metal");
        }
    }

    class Magma extends Liquid{
        Magma(double density, double viscosity){
            this.density = density;
            this.viscosity = viscosity;
        }

    }

    class Water extends Liquid implements Shiny{
        Water(){
            this.density = 1.0;
            this.viscosity = 0.00089;
        }
        public void lookAtReflection() {
            System.out.println("The reflection of your face is distorted by concentric ripples");
        }
    }

    void test(){
        Water waterInstance = new Water();
        Granite graniteInstance = new Granite();
        Magma magmaInstance = new Magma(2.6,0.1);
        IronNickelMeteorite inmInstance = new IronNickelMeteorite();

        for(Phase p: new Phase[] {waterInstance,graniteInstance,magmaInstance,inmInstance}){
            System.out.println(p.getClass().getSimpleName() +" density: "+ p.getDensity());
        }
        System.out.println();

        for(Solid s: new Solid[]{graniteInstance,inmInstance}){
            System.out.println(s.getClass().getSimpleName() +" hardness: "+ s.getHardness());
        }
        System.out.println();

        for(Liquid l: new Liquid[]{magmaInstance,waterInstance}){
            System.out.println(l.getClass().getSimpleName() +" viscosity: "+ l.getViscosity());
        }
        System.out.println();

        for(Shiny s:new Shiny[] {waterInstance,inmInstance}){
            System.out.println("you gaze into the "+ s.getClass().getSimpleName());
            s.lookAtReflection();
            System.out.println();

        }

    }
}
