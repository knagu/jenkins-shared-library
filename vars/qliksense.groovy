def call(Map config=[:]) {
node 
  {
	 
	  
	  stage('GitSCM')
	  {
		  git url: 'https://Knagu@bitbucket.org/Knagu/qliksense.git'
	  }	  
    	 
  }
}
    
