package com.newsaggregator.daos;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newsaggregator.models.NewsSnippet;
import com.newsaggregator.repositories.NewsSnippetRepository;
import com.newsaggregator.utils.EntertainmentFetchUtil;
import com.newsaggregator.utils.HeadlineFetchUtil;
import com.newsaggregator.utils.SportsFetchUtil;

@Component
public class NewsSnippetDao {
	
	@Autowired
	HeadlineFetchUtil headlinesFetchUtils;
	
	@Autowired
	NewsSnippetRepository newsSnippetRepository;
	
	
	@Autowired
	SportsFetchUtil sportsFetchUtils;
	@Autowired
	EntertainmentFetchUtil entertainmentFetchUtil;
	
	public void fetchAndInsertHeadlines()
	{
		try {
			List<NewsSnippet> newsList = headlinesFetchUtils.fetchHeadline("us");
			List<NewsSnippet> existing = (List<NewsSnippet>) newsSnippetRepository.findAll();
			List<String> titles = new ArrayList<String>();
			
			for(int i=0;i< existing.size();i++)
			{
				titles.add(existing.get(i).getHeadline());
			}
			for(int i=0;i< newsList.size();i++)
			{
				if(titles.contains(newsList.get(i).getHeadline()))
				{
					continue;
				}
				else
				{
					newsSnippetRepository.save(newsList.get(i));
				}
			
			}
				
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void fetchAndInsertSports()
	{
		try {
			List<NewsSnippet> newsList = sportsFetchUtils.fetchHeadline("us");
			List<NewsSnippet> existing = (List<NewsSnippet>) newsSnippetRepository.findNewsSnippetByCategory("Sports");
			List<String> titles = new ArrayList<String>();
			
			for(int i=0;i< existing.size();i++)
			{
				titles.add(existing.get(i).getHeadline());
			}
			for(int i=0;i<newsList.size();i++)
			{
				System.out.println(newsList.get(i).getHeadline());
			}
			for(int i=0;i< newsList.size();i++)
			{
				if(titles.contains(newsList.get(i).getHeadline()))
				{
					continue;
				}
				else
				{
					newsSnippetRepository.save(newsList.get(i));
				}
			
			}
				
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void fetchAndInsertEntertainment()
	{
		try {
			List<NewsSnippet> newsList = entertainmentFetchUtil.fetchHeadline("us");
			List<NewsSnippet> existing = (List<NewsSnippet>) newsSnippetRepository.findNewsSnippetByCategory("Entertainment");
			List<String> titles = new ArrayList<String>();
			
			for(int i=0;i< existing.size();i++)
			{
				titles.add(existing.get(i).getHeadline());
			}
			for(int i=0;i< newsList.size();i++)
			{
				if(titles.contains(newsList.get(i).getHeadline()))
				{
					continue;
				}
				else
				{
					newsSnippetRepository.save(newsList.get(i));
				}
			
			}
				
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void fetchAndInsertScience()
	{
		try {
			List<NewsSnippet> newsList = headlinesFetchUtils.fetchScience("us");
			List<NewsSnippet> existing = (List<NewsSnippet>) newsSnippetRepository.findNewsSnippetByCategory("Science");
			List<String> titles = new ArrayList<String>();
			
			for(int i=0;i< existing.size();i++)
			{
				titles.add(existing.get(i).getHeadline());
			}
			for(int i=0;i< newsList.size();i++)
			{
				if(titles.contains(newsList.get(i).getHeadline()))
				{
					continue;
				}
				else
				{
					newsSnippetRepository.save(newsList.get(i));
				}
			
			}
				
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void fetchAndInsertBusniess()
	{
		try {
			List<NewsSnippet> newsList = headlinesFetchUtils.fetchBusniess("us");
			List<NewsSnippet> existing = (List<NewsSnippet>) newsSnippetRepository.findNewsSnippetByCategory("Busniess");
			List<String> titles = new ArrayList<String>();
			
			for(int i=0;i< existing.size();i++)
			{
				titles.add(existing.get(i).getHeadline());
			}
			for(int i=0;i< newsList.size();i++)
			{
				if(titles.contains(newsList.get(i).getHeadline()))
				{
					continue;
				}
				else
				{
					newsSnippetRepository.save(newsList.get(i));
				}
			
			}
				
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
