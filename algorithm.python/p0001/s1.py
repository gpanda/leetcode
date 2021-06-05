class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        d = {}
        l = len(nums)
        for i in range(0, l):
            v = target -  nums[i]
            if d.has_key(v):
                return [d[v], i]
            else:
                d[nums[i]] = i

