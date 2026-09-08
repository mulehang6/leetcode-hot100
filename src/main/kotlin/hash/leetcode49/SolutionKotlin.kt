package hash.leetcode49

class SolutionKotlin {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()

        for (str in strs) {
            val sortedS = str.toCharArray()
            sortedS.sort()
            map.getOrPut(String(sortedS)) { mutableListOf() }.add(str)
        }
        return ArrayList(map.values)
    }
}