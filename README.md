# maven-archetypes

This project contains a set of maven archetypes for generating project scaffolding.

This project is a work-in-progress, in particular some of the sub-project archetypes may not be complete.

The project structures are related and are designed to be generated as sub-projects within 
a parent maven project generated with the parent-archetype archetype.

The parent-archetype generates the following modules : common, core, tools, services, web-fragments, portals.
Sub-project archetypes should be used within the appropriate module.

Usage : 

First run 
$ mvn clean install

to install the archetypes so they are accessible to maven.

Then generate a parent project
$ mvn archetype:generate -DgroupId=yourgroup -DartifactId=yourproject 
-DarchetypeGroupId=com.gmail.gtassone -DarchetypeArtifactId=parent-archetype -DarchetypeVersion=0.0.1-SNAPSHOT

This will run interactive mode, and you will be prompted to set additional properties. If you want to
change the defaults, answer 'N' at the OK prompt, and you can set every property.

Now you can build out your object model interfaces in core/core-model, JPA entities in core/core-entities, and so on.

You can also add sub-projects using the other archetypes. Just be sure to add them in the appropriate module.
