package com.company;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * initialize the Logger
     */
    private static final Logger logger = LogManager.getLogger(Main.class);
    private List<List<Integer>> result;

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {1, 2, 3, 4};
        /**
         * for logger warning demo
         * */
        List<List<Integer>> result1 = s.kSumII(A, 6, 5);
        /**
         * for logger error demo
         * */
        List<List<Integer>> result2 = s.kSumII(A, 2, 0);
        /**
         * for logger debug demo
         * */
        List<List<Integer>> result3 = s.kSumII(A, 2, 5);
        print(result3);
    }

    public static void print(List<List<Integer>> result) {
        for (List<Integer> res : result) {
            for (Integer i : res) {
                System.out.println(i + " ");
            }
            System.out.println();
        }
    }
}

    class Solution {
    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param targer: an integer
     * @return: A list of lists of integer
     */
        /**
         * initialize the logger
         * */
        private static final Logger logger = LogManager.getLogger(Solution.class);
        private List<List<Integer>> result;

        public Solution() {
            /**
             * set the logger level
             * */
            logger.setLevel(Level.TRACE);
        }

        public List<List<Integer>> kSumII(int[] A, int k, int target) {
            result = new ArrayList<>();
            if (A == null || A.length < k) {
                logger.warn("the size of the input array shuold >= " + k);
                return result;
            }

            List<Integer> path = new ArrayList<>();
            logger.info("begin DFS");
            helper(A, path, target, k, 0, 0);
            logger.info("exist DFS");

            if (result.size() == 0) {
                logger.error("the result is empty!");
            }

            return result;
        }

        private void helper(int[] A, List<Integer> path, int target, int k, int sum, int index) {
            if (path.size() == k) {
                if (sum == target) {
                    logger.trace("get one result");
                    logger.debug("the content of the path is:");
                    for (Integer i : path) {
                        logger.debug(i + " ");
                    }
                    result.add(new ArrayList<Integer>(path));
                }
                return;
            }

            if (index == A.length) {
                return;
            }

            logger.trace("the index now is: " + index);
            logger.debug("the content of the path is:");
            for (Integer i : path) {
                logger.debug(i + " ");
            }

            for (int i = index; i < A.length; ++i) {
                if (sum + A[i] > target) {
                    continue;
                }
                path.add(A[i]);
                helper(A, path, target, k, sum + A[i], i + 1);
                path.remove(path.size() - 1);
            }
        }
    }