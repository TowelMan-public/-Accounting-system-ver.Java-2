package com.example.demo;

public class RegexpMessage {
	static final public String INTEGER = "整数で入力してください";
	static final public String AUTHORITY = "権限は「MASTER」か「USER」でお願いします";
	static final public String EMPTY = "何かしら入力してください（空っぽはだめです）";
	static final public String RATE = "率の指定は、0以上1以下でお願いします";
	static final public String ID_OR_NAME = "番号（整数）か、名前等を入力してください";
	static final public String ID_OR_ID_AND_NAME = "番号（整数）で指定するかデータリストから選択してください";
	static final public String DATE = "日付を、「2020-9-8」のように入力してください";
	static final public String RANGE_DATE = "日付を、「2020-9-8」のように入力し、「日付A」、「日付A-日付B」、「-日付B」のように入力してください";
	static final public String RANGE_INTEGER = "数字を「12」、「12-20」、「-50」のように入力してください";
}
