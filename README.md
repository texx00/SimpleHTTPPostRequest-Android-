# Simple Async HTTP Post Request #

[This class](https://github.com/texx00/SimpleHTTPPostRequest/blob/master/app/src/main/java/com/texx/simplehttppostrequest/HTTPPostTask.java "This class") is an easy way to perform an async HTTP POST request.  
 
This want to be a class for beginners and may be too simple for your needs.
  
With only few lines is possible to perform a basic request with as many parameters as you want.  

## How to use ##

Download and import the [HTTPPostTask.class](https://github.com/texx00/SimpleHTTPPostRequest/blob/master/app/src/main/java/com/texx/simplehttppostrequest/HTTPPostTask.java "This class") in your package then:

    HTTPPostTask.HTTPPostTaskListener listener=new HTTPPostTask.HTTPPostTaskListener(){
	
		@Override
        public void onDataReceived( String result ) {
        	...  
        }
        
        @Override
        public void onError(Context c){
        	/*	what to do if an error occurs	*/
        }
	}
    HTTPPostTask task=new HttpPostTask(context, url, listener);
	task.addPostParam(name1, value1);
	task.addPostParam(name2, value2);
	...
	task.execute();

The repository include a complete example (with json) (app and [serverside](https://github.com/texx00/SimpleHTTPPostRequest/blob/master/calc.php "serverside"))
  
**I'm open to any suggestion or question ;) Tell me if I'm doing something wrong or if something can be added**
