//package bowling.view
//
//import bowling.domain.frame.LastFrame
//import bowling.domain.frame.NormalFrame
//
//class ResultPrintVisitor {
//    fun parseResult(normalFrame: NormalFrame): String {
//        val result = normalFrame.result()
//        val stringBuilder = StringBuilder()
//
//        val first = result.getOrNull(0)
//        val second = result.getOrNull(1)
//
//        if (first != null) {
//            stringBuilder.append(FirstPitchShape.shapeOfCount(first.count()))
//
//            if (second != null) {
//                stringBuilder.append("|")
//                    .append(SecondPitchShape.shapeOfCount(second.count(), first!!.count() + second.count()))
//            }
//        }
//
//        return stringBuilder.toString()
//            .padEnd(4, ' ')
//    }
//
//    fun parseResult(lastFrame: LastFrame): String {
//        val result = lastFrame.result()
//        val stringBuilder = StringBuilder()
//
//        val first = result.getOrNull(0)
//        val second = result.getOrNull(1)
//        val bonus = result.getOrNull(2)
//
//        if (first != null) {
//            stringBuilder.append(FirstPitchShape.shapeOfCount(first.count()))
//
//            if (second != null) {
//                if (first.count() == 10) {
//                    stringBuilder.append("|")
//                        .append(FirstPitchShape.shapeOfCount(second.count()))
//                } else {
//                    stringBuilder.append("|")
//                        .append(SecondPitchShape.shapeOfCount(second.count(), first.count() + second.count()))
//                }
//
//                if (bonus != null) {
//                    if (first.count() + second.count() == 10) {
//                        stringBuilder.append("|")
//                            .append(FirstPitchShape.shapeOfCount(bonus.count()))
//                    } else {
//                        stringBuilder.append("|")
//                            .append(SecondPitchShape.shapeOfCount(bonus.count(), second.count() + bonus.count()))
//                    }
//                }
//            }
//        }
//
//        return stringBuilder.toString()
//            .padEnd(4, ' ')
//    }
//}
//
//class FirstPitchShape {
//    companion object {
//        fun shapeOfCount(count: Int): String {
//            if (count == 10) {
//                return "X"
//            }
//
//            if (count == 0) {
//                return "-"
//            }
//
//            return count.toString()
//        }
//    }
//}
//
//class SecondPitchShape {
//    companion object {
//        fun shapeOfCount(count: Int, sum: Int): String {
//            if (sum == 10) {
//                return "/"
//            }
//
//            if (count == 0) {
//                return "-"
//            }
//
//            return count.toString()
//        }
//    }
//}