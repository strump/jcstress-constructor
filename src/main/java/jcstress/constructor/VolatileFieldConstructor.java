package jcstress.constructor;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.Description;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.I_Result;

@JCStressTest
@Description("Tests field initialization")
@Outcome(id = "1", expect = Expect.ACCEPTABLE, desc = "Instance of M is not initialized")
@Outcome(id = "42", expect = Expect.ACCEPTABLE,  desc = "Happy path")
@Outcome(expect = Expect.FORBIDDEN, desc =  "All other cases are forbidden.")
@State
public class VolatileFieldConstructor {

    public M m;

    @Actor
    public void actor1() {
        m = new M();
    }

    @Actor
    public void actor2(I_Result r) {
        M lm = m;
        if (lm !=null) {
            r.r1 = lm.x;
        }
        else {
            r.r1 = 1;
        }
    }

    static final class M {
        int x;

        M() {
            x = 42;
        }
    }
}
