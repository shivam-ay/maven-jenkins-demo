package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private int projectId;
	@Column(name = "project_name")
	private String projectName;
	@Column(name = "project_description")
	private String projectDesc;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name ="end_date")
	private LocalDate endDate;
	@Column(name = "status")
	private boolean status;
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	@JsonBackReference(value = "project-task")
    private List<Task> tasks;

	@ManyToOne
	@JoinTable(
			name = "user_project",
			joinColumns = @JoinColumn(name = "project_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private User user;
}

