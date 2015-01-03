# SimpleHTTPPostRequest #

This class is an easy way to perform an async HTTP POST request.  
This want to be a class for begginners and may be too simple for your needs.
  
With only few lines is possible to perform a basic request with as many parameters as you want.  

## How to use ##

Import the class in your package then:

    HTTPPostTask.HTTPPostTaskListener listener=new HTTPPostTask.HTTPPostTaskListener(){
		@Override
        public void onDataReceived(Context context, String result) {
        	...  
        }
	}
    HTTPPostTask task=new HttpPostTask(context, url, listener);
	task.addPostParam(name1, value1);
	task.addPostParam(name2, value2);
	...
	task.execute();

The repository include a complete example (app and serverside)
  
**I'm open to any suggestion ;) Tell me if I'm doing something wrong if something can be added**