package pl.coderstrust.ip_checker_regex;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertFalse;


@RunWith(JUnitParamsRunner.class)
public class IPAddressCheckerNotValidCasesTest {
    private static IpAddressChecker ipChecker = new IpAddressChecker();

    @Test
    @Parameters({
            "0",
            "0.0",
            "0.0.0",
            "255",
            "255.255",
            "255.255.255",
            "122",
            "182.120",
            "281.234.122"
    })
    public void shouldReturnFalseForIncompleteIp(final String ipAddress) {
        assertFalse(ipChecker.isIpAddress(ipAddress));
    }

    @Test
    @Parameters({
            "0.",
            "0.0.",
            "0.0.0.",
            "0.0.0.0.",
            "255.",
            "255.255.",
            "255.255.255.",
            "255.255.255.255.",
            "122.",
            "182.120.",
            "281.234.122.",
            "281.234.122.201."
    })
    public void shouldReturnFalseForIncompleteIpEndingWithDot(final String ipAddress) {
        assertFalse(ipChecker.isIpAddress(ipAddress));
    }

    @Test
    @Parameters({
            ".0",
            ".0.0",
            ".0.0.0",
            ".0.0.0.0",
            ".255",
            ".255.255",
            ".255.255.255",
            ".255.255.255.255",
            ".122",
            ".182.120",
            ".281.234.122",
            ".281.234.122.201",
    })
    public void shouldReturnFalseForIncompleteIpBeginningWithDot(final String ipAddress) {
        assertFalse(ipChecker.isIpAddress(ipAddress));
    }

    @Test
    @Parameters({
            "256.192.222.112",
            "192.256.222.112",
            "192.222.256.112",
            "192.222.112.256"
    })
    public void shouldReturnFalseForIpWithElementsAbove255(final String ipAddress) {
        assertFalse(ipChecker.isIpAddress(ipAddress));
    }

    @Test
    @Parameters({
            "-233.192.222.112",
            "192.-233.222.112",
            "192.222.-233.112",
            "192.222.112.-233"
    })
    public void shouldReturnFalseForIpWithNegativeElements(final String ipAddress) {
        assertFalse(ipChecker.isIpAddress(ipAddress));
    }

    @Test
    @Parameters({
            "192..168.1.129",
            "192.168..1.129",
            "192.168.1..129"
    })
    public void shouldReturnFalseForIpWithDoubleDots(final String ipAddress) {
        assertFalse(ipChecker.isIpAddress(ipAddress));
    }

    @Test
    @Parameters({
            "192...168.1.129",
            "192.168...1.129",
            "192.168.1...129"
    })
    public void shouldReturnFalseForIpWithTripleDots(final String ipAddress) {
        assertFalse(ipChecker.isIpAddress(ipAddress));
    }

    @Test
    @Parameters({
            "192.222.112.233.121"
    })
    public void shouldReturnFalseForTooLongIp(final String ipAddress) {
        assertFalse(ipChecker.isIpAddress(ipAddress));
    }

    @Test
    @Parameters({
            "a.192.222.112",
            "192.b.222.112",
            "192.222.c.112",
            "192.222.112.d",
            "*.192.222.112",
            "192.*.222.112",
            "192.222.*.112",
            "192.222.112.*"

    })
    public void shouldReturnFalseForIpWithNonNumberCharacters(final String ipAddress) {
        assertFalse(ipChecker.isIpAddress(ipAddress));
    }
}
