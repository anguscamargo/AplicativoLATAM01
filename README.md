# README

#### Github
##### create cache for credentials
~~~
git config credential.helper store
git push
git config --global credential.helper 'cache --timeout 7200'
~~~

##### update project from Github/origin
~~~
git checkout master
git pull
~~~
##### create new branch
~~~
git checkout -b 'branch-name'
~~~
##### delete branch
~~~
git checkout -d 'branch-name'
~~~
##### update branch from master
~~~
git merge master
~~~
##### add specific file to stage before commit
~~~
git add 'filename'
~~~
##### add all files to stage before commit
~~~
git add .
~~~
##### commit staged changes
~~~
git commit -m"changes description here"
~~~
##### push commited changes to Github/origin
~~~
git push
~~~
##### Rollback to the last pushed commit erasing all local changes
~~~
git reset --hard
~~~
##### Rollback to the last pushed commit without erasing local changes
~~~
git reset --soft
~~~
##### Rollback to the last unpushed commit without erasing local changes
~~~
git reset --soft HEAD~1
~~~
