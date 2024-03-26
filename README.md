# Matrix-Calculus-and-Multivariate-Statistics

This repository hosts programs developed for the "Matrix Calculus and Multivariate Statistics" course at AGH University during the academic year 2023/2024. 
The programms are written along with paula078.

### Program 1: Matrix Multiplication Methods Implementation

Objective:

The primary objective of this program is to implement two distinct matrix multiplication methods:

- Classic Matrix Multiplication
- Binet Matrix Multiplication

Methodology:

The program further incorporates an algorithm that bridges these two approaches. Initially, it divides the given matrices recursively into block matrices.
These blocks, starting from a designated parameter "l", are then multiplied using the traditional method and subsequently reassembled.

Evaluation:

The program assesses the performance by comparing the execution time and floating-point operations per second for various "l" parameters.

*Assumption: The program operates on square matrices with sizes that are powers of two.*


### Program 2: Gaussian Elimination and LU Factorization

Objective:

This program aims to implement efficient solutions for solving systems of linear equations by incorporating the following techniques:

- Gaussian elimination (with and without pivoting)
- LU factorization (with and without pivoting)
