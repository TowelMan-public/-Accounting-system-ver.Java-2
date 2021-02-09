package com.example.demo.candidate;

public class CandidateForm {
	private Integer candidateId;
	private String candidateName;
	//多分getterしか呼ばれない プロパティとしてしか存在しない 候補として表示するときの文字列
	private String candidateStr;
	
	public Integer getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getCandidateStr() {
		candidateStr = candidateId.toString() + ":" + candidateName;
		return candidateStr;
	}
}
