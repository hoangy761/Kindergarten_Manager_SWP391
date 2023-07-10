function getBotResponse(input) {
    //rock paper scissors
    if (input == "xin chào") {
        return "ô!!!Chúng tôi có thể trao đổi bằng tiếng việt.Bạn cần chúng tôi trợ giúp gì không?";
    } else if (input == "tôi muốn biết về thông tin của trường") {
        return "Trường mẫu giáo ABC được thành lập vào năm 2023,với quy mô toàn quốc và giáo trình dạy quốc tế.Ở đây,con bạn sẽ được thoả sức vui chơi,học tập và sáng tạo.hãy đăng ký tài khoản để biết thêm thông tin về trường.";
    } else if (input == "học phí của trường") {
        return "Học phí của trường giao động từ 2-4tr đồng 1 tháng,phụ thuộc vào trương trình và dịch vụ lựa chọn.Nhưng chúng tôi đảm bảo tiền nào của nấy.";
    }else if (input == "cảm ơn") {
        return "cảm ơn bạn đã ghé thăm,tạm biệt";
    }else if (input == "hello") {
        return "Hello there!";
    } else if (input == "tell me about this school") {
        return "ABC Kindergarten was established in 2023, with a national scale and international teaching curriculum. Here, your children will be free to have fun, learn and be creative. Please register for an account for more information. school news.";
    }else if (input == "tuition fee") {
        return "School fees range from $100-200 per month, depending on the program and service you choose. But we guarantee you get what you pay for.";
    }else{
        return "bạn có gì muốn hỏi thêm không?";
    }
    // Simple responses
}