// Question Link: https://www.geeksforgeeks.org/problems/data-type-1666706751/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=data-type


class Solution {
    static int dataTypeSize(String str) {
        // Check the input string and return the corresponding size in bytes
    
        // If the input is "Character", return 2 bytes
        if (str.equals("Character")) {
            return 2;
        } 
        // If the input is "Integer", return 4 bytes
        else if (str.equals("Integer")) {
            return 4;
        } 
        // If the input is "Long", return 8 bytes
        else if (str.equals("Long")) {
            return 8;
        } 
        // If the input is "Float", return 4 bytes
        else if (str.equals("Float")) {
            return 4;
        } 
        // If the input is "Double", return 8 bytes
        else if (str.equals("Double")) {
            return 8;
        }
    
        // Return -1 if the input does not match any known data type
        return -1;
    }
