class Solution(object):
    def countSeniors(self, details):
        """
        :type details: List[str]
        :rtype: int
        """
        count = 0
        for detail in details:
            age = int(detail[11:13])  # Extract age and convert to integer
            if age > 60:
                count += 1
        return count