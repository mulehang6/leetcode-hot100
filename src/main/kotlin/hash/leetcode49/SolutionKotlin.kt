package hash.leetcode49

class SolutionKotlin {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()

        for (str in strs) {
            val sortedS = str.toCharArray()
            sortedS.sort()
            map.getOrPut(String(sortedS)) { mutableListOf() }.add(str)
        }
        return map.values.toList()
    }
}