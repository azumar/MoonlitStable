/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.account.config;

/**
 *
 * @author umar_
 */
public abstract class AbstractMessageConfig {
   private  String name;
	private String subject;
	private String content;
	private String signature;
	
	public AbstractMessageConfig(String name, String subject, String content, String signature) {
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.signature = signature;
		
	}
	public AbstractMessageConfig() {
		
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
}
