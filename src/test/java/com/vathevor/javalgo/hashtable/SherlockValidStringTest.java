package com.vathevor.javalgo.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SherlockValidStringTest {

    @Test
    void testCase1() {
        String input = "aabbcd";

        boolean result = SherlockValidString.isValid(input);

        assertFalse(result);
    }

    @Test
    void testCase2() {
        String input = "aabbccddeefghi";

        boolean result = SherlockValidString.isValid(input);

        assertFalse(result);
    }

    @Test
    void testCase3() {
        String input = "abcdefghhgfedecba";

        boolean result = SherlockValidString.isValid(input);

        assertTrue(result);
    }

    @Test
    void testCase4() {
        String input = "aaaabbcc";

        boolean result = SherlockValidString.isValid(input);

        assertFalse(result);
    }

    @Test
    void testCase5() {
        String input = "xxxaabbccrry";

        boolean result = SherlockValidString.isValid(input);

        assertFalse(result);
    }

    @Test
    void testCase6() {
        String input = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgg" +
                "hbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfi" +
                "fhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcede" +
                "cafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifi" +
                "hbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgc" +
                "edechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfb" +
                "cghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgd" +
                "deehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaa" +
                "iadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbg" +
                "bghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdc" +
                "bhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffi" +
                "ageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggi" +
                "ffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaa" +
                "dedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcga" +
                "hcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";

        boolean result = SherlockValidString.isValid(input);

        assertTrue(result);
    }

    @Test
    void testCase7() {
        String input = "abcdefghhgfedecba";

        boolean result = SherlockValidString.isValid(input);

        assertTrue(result);
    }
}
