package ch06

class P6_3 {

    fun sortLog1(logs: List<String>): List<String> {
        val stringLogs = mutableListOf<String>()
        val digitLogs = mutableListOf<String>()

        for (log in logs) {
            if (log.split(' ')[1][0].isDigit()) {
                digitLogs.add(log)
            } else {
                stringLogs.add(log)
            }
        }

        stringLogs.sortWith(Comparator { log1: String, log2: String ->
            val (log1Id, log1String) = log1.split(' ')
            val (log2Id, log2String) = log2.split(' ')

            val compared = log1String.compareTo(log2String)
            if (compared == 0) {
                log1Id.compareTo(log2Id)
            } else {
                compared
            }
        })

        return stringLogs + digitLogs
    }

    /**
     * java comparator
     *
     * Collections.sort(logs, new Comparator<String>() {
     *   @override
     *   public int comapre(String s1, String s2) {
     *     String[] s1x = s1.split(" ",2);
     *     String[] s2x = s2.split(" ",2);
     *
     *     int compared = s1x[1].compareTo(s2x[1]);
     *     if (compared == 0) {
     *       return s1x[0].compareTo(s2x[0);
     *     } else {
     *       return compared;
     *     }
     */
}