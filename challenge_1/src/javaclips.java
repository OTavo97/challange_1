package clips;
 import net.sf.clipsrules.jni.Environment;

public class javaclips
{
    public static void main (String[] noseusa) throws Exception
    {
        Environment env = new Environment();
        env.eval("(reset)");
        env.eval("(assert (person pepe))");
        env.eval("(assert (sign stressout))");
        env.eval("(assert (person covid positive))");
        env.eval("(assert (gastritis))");
        env.eval("(assert (threw up))");

        env.eval("(facts)");
    }
}