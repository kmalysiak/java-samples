package pl.coderstrust.ip_checker_regex;

import java.util.regex.Pattern;

public class IpAddressChecker {
    private static final String IP_FIELD_REGEX_PATTERN = "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";
    private static final String IP_ADDRESS_REGEX_PATTERN = "^(" + IP_FIELD_REGEX_PATTERN + "\\.){3}" + IP_FIELD_REGEX_PATTERN + "$";


    private Pattern pattern;

    public IpAddressChecker() {
        pattern = Pattern.compile(IP_ADDRESS_REGEX_PATTERN);
    }


    public boolean isIpAddress(String input) {
        return pattern.matcher(input).matches();
    }
}
