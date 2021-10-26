package com.spring_crud.demo.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Post")
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="post_id")
	private int postId;
	
	@Column(name="post_title")
	private String title;
	
	@Column(name="post_date")
	private Date postDate;
	
	@ManyToOne
	@JoinColumn(name="series_id")
	private Series series;
	
	@OneToOne(mappedBy = "post")
	private Book book;
	
	@ManyToMany
	@JoinTable(
			name="user_post",
			joinColumns = @JoinColumn(name="post_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			
			)
	private Set<User> user;
	
	
	public Series getSeries() {
		return series;
	}
	public void setSeries(Series series) {
		this.series = series;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(postDate, postId, series, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(postDate, other.postDate) && postId == other.postId
				&& Objects.equals(series, other.series) && Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", postDate=" + postDate + ", series=" + series + "]";
	}

	

}
