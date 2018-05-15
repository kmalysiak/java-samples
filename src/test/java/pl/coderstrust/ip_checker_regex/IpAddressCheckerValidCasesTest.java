package pl.coderstrust.ip_checker_regex;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class IpAddressCheckerValidCasesTest {
    private static IpAddressChecker ipChecker = new IpAddressChecker();

    @Test
    @Parameters(method = "validIpTestData")
    public void shouldReturnTrueForSampleValidIP(String ipAddress) {
        assertTrue(ipChecker.isIpAddress(ipAddress));
    }

    private String[] validIpTestData() {
        String[] ipAddresses = new String[4 * 256];
        int testCase = 0;
        for (int i = 0; i < 256; i++) {
            ipAddresses[testCase] = i + ".1.1.1";
            testCase++;
        }
        for (int i = 0; i < 256; i++) {
            ipAddresses[testCase] = "1." + i + ".1.1";
            testCase++;
        }
        for (int i = 0; i < 256; i++) {
            ipAddresses[testCase] = "1.1." + i + ".1";
            testCase++;
        }
        for (int i = 0; i < 256; i++) {
            ipAddresses[testCase] = "1.1.1." + i;
            testCase++;
        }
        return ipAddresses;
    }
    @Ignore("Test takes long time to execute and is partiallly covered in other tests. Run only in case of major cod changes")
    @Test
    public void shouldReturnTrueForAllValidIP() {
        StringBuilder builder;
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                for (int k = 0; k < 256; k++) {
                    for (int l = 0; l < 256; l++) {
                        builder = new StringBuilder();
                        builder.append(i);
                        builder.append(".");
                        builder.append(j);
                        builder.append(".");
                        builder.append(k);
                        builder.append(".");
                        builder.append(l);
                        assertTrue(ipChecker.isIpAddress(builder.toString()));
                    }
                }
            }
        }
    }
}