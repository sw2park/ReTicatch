package com.danaojo.reticatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "REVIEW")
@Getter @Setter
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Review_seq")
	@SequenceGenerator(name = "Review_seq", sequenceName = "seq_review_id", allocationSize = 1)
	private Long seq_Review_id;
	
	private String review_content;
	private String review_date;
	private Long rating;
	
	@ManyToOne
	@JoinColumn(name = "seq_user_id")
	private Users seq_user_id;

	@ManyToOne
	@JoinColumn(name = "seq_pfjoin_id")
	private PFJoin seq_pfjoin_id;
}
