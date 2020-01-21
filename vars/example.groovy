def call(Map config=[:], Closure body) {
node 
  {
     stage('GitSCM')
    {
        git url: 'https://github.com/selvan123/petclinic.git'
    }
    stage('Build Stage')
    {
	   sh "${mvnHome}/bin/mvn -B verify"
    }
  }
}
    
