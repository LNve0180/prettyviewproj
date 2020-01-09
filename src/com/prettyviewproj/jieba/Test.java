package com.prettyviewproj.jieba;

public class Test {

	public static void main(String[] args) {
		String str = "这是第四次次尝试启动jeba分词器";
		JiebaSegmenter segmenter = new JiebaSegmenter();
		
		System.out.println(segmenter.sentenceProcess(str));

	}

}
