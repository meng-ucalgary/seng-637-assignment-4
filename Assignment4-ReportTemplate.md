# SENG-637 Assignment 4

**Topic** - Mutation Testing and Web app testing

## Table of Contents

- [Introduction](#introduction)
- [Video demo](#video-demo)
- [Analysis of 10 mutants of the Range class](#analysis-of-10-mutants-of-the-range-class)
- [Mutation score and statistics](#mutation-score-and-statistics)
- [Analysis drawn on the effectiveness of each of the test classes](#analysis-drawn-on-the-effectiveness-of-each-of-the-test-classes)
- [A discussion on the effect of equivalent mutants on mutation score accuracy](#a-discussion-on-the-effect-of-equivalent-mutants-on-mutation-score-accuracy)
- [A discussion of what could have been done to improve the mutation score of the test suites](#a-discussion-of-what-could-have-been-done-to-improve-the-mutation-score-of-the-test-suites)
- [Need for mutation testing](#need-for-mutation-testing)
- [Explain your SELENUIM test case design process](#explain-your-selenium-test-case-design-process)
- [Explain the use of assertions and checkpoints](#explain-the-use-of-assertions-and-checkpoints)
- [How did you test each functionaity with different test data](#how-did-you-test-each-functionaity-with-different-test-data)
- [Selenium vs Sikulix](#selenium-vs-sikulix)
- [Division of team work](#division-of-team-work)
- [Difficulties, challenges, and lessons learned](#difficulties-challenges-and-lessons-learned)
- [Comments and feedback](#comments-and-feedback)
- [Contributors](#contributors)

## Introduction

## Video demo

Link to the video demonstration of killed/surviving mutants and is _TBA_.

## Analysis of 10 mutants of the Range class

## Mutation score and statistics

After commenting out failing test cases in Assignment 3, we ran mutation tests on `Range` and `DataUtilities`.

- **Mutation score of Range - before**

  ![Range_Mutants_Score_Before](images/Range_Mutants_Score_Before.png)

- **Mutation statistics of Range - before**

  ![Range_Mutants_Statistics_Before](images/Range_Mutants_Statistics_Before.png)

- **Mutation score of DataUtilities - before**

  ![DataUtilities_Mutants_Score_Before](images/DataUtilities_Mutants_Score_Before.png)

- **Mutation statistics of DataUtilities - before**

  ![DataUtilities_Mutants_Statistics_Before](images/DataUtilities_Mutants_Statistics_Before.png)

After adding more test cases, we again ran mutation tests on `Range` and `DataUtilities`.

- **Mutation score of Range - after**

  ![Range_Mutants_Score_After](images/Range_Mutants_Score_After.png)

- **Mutation statistics of Range - after**

  ![Range_Mutants_Statistics_After](images/Range_Mutants_Statistics_After.png)

- **Mutation score of DataUtilities - after**

  ![DataUtilities_Mutants_Score_After](images/DataUtilities_Mutants_Score_After.png)

- **Mutation statistics of DataUtilities - after**

  ![DataUtilities_Mutants_Statistics_After](images/DataUtilities_Mutants_Statistics_After.png)

## Analysis drawn on the effectiveness of each of the test classes

## A discussion on the effect of equivalent mutants on mutation score accuracy

## A discussion of what could have been done to improve the mutation score of the test suites

## Need for Mutation Testing

**Need**

Mutation testing is required to test the effectiveness of the test suite. It process by which we can determine if the test suite is detecting injected bugs.

- **Advantages**[[1]](https://www.softwaretestingclass.com/mutation-testing-advantages-and-disadvantages/)

  - Mutation testing has the ability to detect all faults in the source code
  - High coverage of the source program is attained
  - Program mutants are tested thoroughly
  - Quality of software program is improved
  - Loopholes in test data can be identified

- **Disadvantages**[[1]](https://www.softwaretestingclass.com/mutation-testing-advantages-and-disadvantages/)

  - Complex mutations are difficult to implement
  - Mutation testing is time-consuming and expensive
  - Mutation testing is not applicable for black-box testing as involves a lot of source code changes
  - Automation is necessary for mutation testing as it is very time-consuming

## Explain your SELENUIM test case design process

## Explain the use of assertions and checkpoints

## How did you test each functionaity with different test data

## Selenium vs Sikulix

## Division of team work

## Difficulties, challenges, and lessons learned

There was some issues while setting up of Pitest in Eclipse. During the installaion of Pitest from the Eclipse marketplace, one of the group member was getting errors like below.

```
An error occurred while collecting items to be installed
  session context was:(profile=C__Program Files_Eclipse_eclipse,
  phase=org.eclipse.equinox.internal.p2.engine.phases.Collect,
  operand=, action=).

  No repository found containing:
  osgi.bundle,com.google.guava,21.0.0.v20170206-1425
```

Later it was found that the problem is arising with newer version of the Eclipse. After downgrading Eclipse from **2021-12** to **2021-03**, Pitest was installed successfully.

## Comments and feedback

## Contributors

We are group 5, and below are the team members

- [Bhavyai Gupta](https://github.com/zbhavyai)
- [Drew Burritt](https://github.com/dburritt)
- [Michael Man Yin Lee](https://github.com/mlee2021)
- [Okeoghenemarho Obuareghe](https://github.com/oobuareghe)
