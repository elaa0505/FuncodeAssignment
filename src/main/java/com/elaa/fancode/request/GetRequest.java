package com.elaa.fancode.request;

public class GetRequest {

	public static String BaseURI() {
		String baseuri= "http://jsonplaceholder.typicode.com/";
		return baseuri;
	}
	
	public static String ResourceUsers() {
		String resource = "/users";
		return resource;
	}
	
	public static String ResourceTodo() {
		String resource = "/todos";
		return resource;
	}
	public static String ResourcePosts() {
		String resource = "/posts";
		return resource;
	}
	public static String ResourceComments() {
		String resource = "/comments";
		return resource;
	}
	public static String ResourcePhotos() {
		String resource = "/photos";
		return resource;
	}

}
