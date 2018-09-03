<#import "parts/common.ftl" as c>
<#import "parts/carousel.ftl" as crs>
<@c.page>
    <div class="container">
        <div class="row">
            <div class="col col-lg-3">
                <h1>Hello,guest!</h1>
                <p class="text-justify">Build the computer online with us - it is carefully verified and honed over many years of technological process. We collected and tested more than thirteen thousand system blocks. With the help of our service, you can assemble your dream computer and test it for efficiency. Our specialists are happy to help you with the choice of accessories and always remember that they are collecting you a loyal and reliable friend.
                </p>
            </div>
            <div class="col-md-auto">
               <@crs.carousel/>
            </div>
        </div>
    </div>

</@c.page>