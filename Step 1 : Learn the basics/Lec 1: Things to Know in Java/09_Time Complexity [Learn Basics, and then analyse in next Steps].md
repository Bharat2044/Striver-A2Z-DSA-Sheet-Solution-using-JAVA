## Time complexity
Time complexity is a measure of the amount of time it takes for an algorithm to solve a problem as a function of the size of the input. It is often expressed in terms of the "big O" notation, which describes the worst-case scenario for the running time of the algorithm, as the input size approaches infinity.

The time complexity of an algorithm is usually analyzed by counting the number of basic operations it performs on the input data, such as arithmetic operations, comparisons, and assignments. This count is then used to determine how the running time of the algorithm grows with the size of the input.

For example, if an algorithm performs a constant amount of work for each element in an array of length N, its time complexity is O(N), meaning that its running time grows linearly with the size of the input. Similarly, if an algorithm performs a logarithmic number of operations for each element in an array of length N, its time complexity is O(log N), meaning that its running time grows at a slower rate than linearly.

Time complexity is an important consideration when designing and implementing algorithms, as it can have a significant impact on the performance of a program. Algorithms with lower time complexity are generally considered to be more efficient, as they can solve problems faster or with less resources than algorithms with higher time complexity. However, it is important to note that time complexity is just one factor to consider when evaluating the performance of an algorithm, and other factors such as space complexity, readability, and maintainability may also be important.

To analyze the time complexity of an algorithm, we typically count the number of basic operations that the algorithm performs on the input data, and then express this count as a function of the size of the input. Some common operations that are used to measure the running time of an algorithm include arithmetic operations, comparisons, assignments, and memory accesses.

### Here are some common time complexity classes and examples of algorithms that fall into each class:

- `O(1)`: constant time complexity. Examples include accessing a single element in an array, or performing a basic arithmetic operation.

- `O(logn)`: logarithmic time complexity. Examples include performing a binary search on a sorted array, or searching a balanced binary tree.

- `O(n)`: linear time complexity. Examples include iterating over the elements of an array or a linked list, or searching an unsorted array for a specific value.

- `O(nlogn)`: quasi-linear time complexity. Examples include performing a merge sort or a quicksort on an array.

- `O(n^2)`: quadratic time complexity. Examples include performing a bubble sort or an insertion sort on an array, or computing the pairwise distances between all pairs of points in a set.

- `O(2^n)`: exponential time complexity. Examples include solving the traveling salesman problem or the subset sum problem using brute-force search.

It is important to note that the actual running time of an algorithm may vary depending on the specific input data, and that time complexity analysis provides only an upper bound on the running time. 
Nevertheless, time complexity analysis can be a useful tool for comparing the efficiency of different algorithms, and for identifying potential performance bottlenecks in a program.


## References
- [Striver](https://takeuforward.org/time-complexity/time-and-space-complexity-strivers-a2z-dsa-course/)
- [GFG](https://www.geeksforgeeks.org/understanding-time-complexity-simple-examples/?ref=header_search)
- [USACO Guide](https://usaco.guide/bronze/time-comp)
