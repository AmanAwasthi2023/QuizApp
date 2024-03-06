package com.aman.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.aman.quiz.dao.QuestionDao;
import com.aman.quiz.model.Question;

@Service
public class QuestionService 
{
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Question>> getAllQuestions()
	{
		try 
		{
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) 
	{
		
		try 
		{
			return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<String> addQuestion(Question question) 
	{
		
		try 
		{
			questionDao.save(question);
			return new ResponseEntity<>("success", HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>("Not Added", HttpStatus.BAD_REQUEST);
		
		
	}

	public ResponseEntity<String> deleteQuestion(Question question) 
	{
		
		try 
		{
			questionDao.delete(question);
			return new ResponseEntity<>("deleted", HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>("Not Deleted", HttpStatus.NOT_FOUND);
		
	}

	public ResponseEntity<String> updateQuestion(Question question) 
	{
		try 
		{
			questionDao.save(question);
			return new ResponseEntity<>("updated", HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>("Not Updated", HttpStatus.NOT_FOUND);
		
		
		
	}
}
