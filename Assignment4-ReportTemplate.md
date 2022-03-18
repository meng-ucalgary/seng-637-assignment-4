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
- [Testing functionalities with different test data](#testing-functionalities-with-different-test-data)
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

## Testing functionalities with different test data

Each of the eight functionalities chosen was tested with different test data using Selenium IDe. The table below summarizes functionalities and items that were tested.

| Functionality            | Test                                    |
| ------------------------ | --------------------------------------- |
| Login                    | Test login with invalid password        |
|                          | Test login with valid password          |
| Email preferences        | Test opt-out of all email communication |
|                          | Test opt-in of all email communication  |
| Finding different stores | _TBA_                                   |
|                          | _TBA_                                   |
| Changing account details | _TBA_                                   |
|                          | _TBA_                                   |
| Finding different stores | _TBA_                                   |
|                          | _TBA_                                   |
| Cart                     | Test adding items to the cart           |
|                          | Test removing items from the cart       |
| Wishlist                 | Test adding items to the wishlist       |
|                          | Test removing items from the wishlist   |
| Filtering search results | _TBA_                                   |
|                          | _TBA_                                   |
| _TBA_                    | _TBA_                                   |
|                          | _TBA_                                   |

## Selenium vs Sikulix

**Advantages of Sikulix**

1. Sikulix uses image recognition powered by OpenCV to identify GUI components. This is handy when there is no easy access to a GUI's internals or the source code.

**Disadvantages of Sikulix**

1. Less popular than Selenium, and thus difficult to find support.

2. Requires 64-bit Java 8 or above to work

**Advantages of Selenium**

1. More popular than Sikulix, and thus easy to find support.

2. Selenium IDE can be added as an extension/addon on most of the modern browsers. It doesn't has any special requirements.

**Disadvantages of Selenium**

1. Image recognition to identify GUI components is not possible.

## Division of team work

**Division of Selenium IDE test cases**

| Tester                   | Functionality            |
| ------------------------ | ------------------------ |
| Bhavyai Gupta            | Login                    |
| Bhavyai Gupta            | Email preferences        |
| Drew Burritt             | Finding different stores |
| Drew Burritt             | Changing account details |
| Michael Man Yin Lee      | Cart                     |
| Michael Man Yin Lee      | Wishlist                 |
| Okeoghenemarho Obuareghe | Filtering search results |
| Okeoghenemarho Obuareghe | _TBA_                    |

## Difficulties, challenges, and lessons learned

1. There was some issues while setting up of Pitest in Eclipse. During the installaion of Pitest from the Eclipse marketplace, one of the group member was getting errors like below.

   ```
   An error occurred while collecting items to be installed
     session context was:(profile=C__Program Files_Eclipse_eclipse,
     phase=org.eclipse.equinox.internal.p2.engine.phases.Collect,
     operand=, action=).

     No repository found containing:
     osgi.bundle,com.google.guava,21.0.0.v20170206-1425
   ```

   Later it was found that the problem is arising with newer version of the Eclipse. After downgrading Eclipse from **2021-12** to **2021-03**, Pitest was installed successfully.

2. Some websites add an another authentication factor like **CAPTCHA** when they detect automated interactions with their websites. So, selenium test cases that includes login pause in the middle until the tester manually deals with those CAPTCHAs.

## Comments and feedback

1. This assignment gave us a chance to further improve our test suite using mutation testing.

2. The assignment description document [`Assignment4.md`](Assignment4.md) is very detailed and comprehensive, and it was easy to follow.

## Contributors

We are group 5, and below are the team members

- [Bhavyai Gupta](https://github.com/zbhavyai)
- [Drew Burritt](https://github.com/dburritt)
- [Michael Man Yin Lee](https://github.com/mlee2021)
- [Okeoghenemarho Obuareghe](https://github.com/oobuareghe)
