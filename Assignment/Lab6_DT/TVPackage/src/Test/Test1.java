package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Test1 {

	@ParameterizedTest(name = "{index} => pkg={0}, off={1}, live={2}, yr={3}, expect={4}")
    @CsvSource({
        // Package, offline, live, 1Yr, expected
        //Standard
        "STD, false, false, false, 150",
        "STD, true, false, false, 250",
        "STD, false, true, false, 250",
        "STD, true, true, false, 350",
        "STD, false, false, true, 100",
        "STD, true, false, true, 200",
        "STD, false, true, true, 200",
        "STD, true, true, true, 300",

        //Premium
        "PRE, false, false, false, 350",
        "PRE, true, false, false, 450",
        "PRE, false, true, false, 450",
        "PRE, true, true, false, 550",
        "PRE, false, false, true, 300",
        "PRE, true, false, true, 400",
        "PRE, false, true, true, 400",
        "PRE, true, true, true, 500",

        //Family
        "FAM, false, false, false, 450",
        "FAM, false, true, false, 550",
        "FAM, false, false, true, 400",
        "FAM, false, true, true, 500",

        //Impossible (Family + offline)
        "FAM, true, false, false, -1"
    })
	void allCases(String pkg, boolean offline, boolean live, boolean yr, int expect) {
	    TVPlan.TVPackage planPkg = pkg.equals("STD") ? TVPlan.TVPackage.STANDARD
	                           : pkg.equals("PRE") ? TVPlan.TVPackage.PREMIUM
	                           : TVPlan.TVPackage.FAMILY;
	    TVPlan plan = new TVPlan(offline, live, yr);

	        assertEquals(expect, plan.pricePerMonth(planPkg), 0.01);
	}
}