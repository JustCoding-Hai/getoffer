package top.javahai.leetcode;

public class No3407 {
    public static void main(String[] args) {
        String p = "k*v";
        String s1234 = "kvb";
        System.out.println(hasMatch(s1234, p));
        System.out.println(hasMatch("pep", "q*"));
    }
    public static boolean hasMatch(String s, String p) {
        int starIndex = p.indexOf("*");
        String p1 = p.substring(0, starIndex);
        String p2 = p.substring(starIndex + 1, p.length());
        int sIndex = s.indexOf(p1);
        return s.contains(p1) && s.substring(sIndex + p1.length(), s.length()).contains(p2);
    }
}
