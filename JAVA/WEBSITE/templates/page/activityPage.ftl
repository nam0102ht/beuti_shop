<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <#include "cssscript.ftl">
        <link rel="stylesheet" type="text/css" href="css/profile.css">
        <script src="js/updateAccount.js"></script>
        <script src="js/blogpost.js"></script>
        <link rel="stylesheet" href="css/activity.css">
        <script src="js/activity.js"></script>
    </head>
    <body>
        <#include "header.ftl">
        <section style="padding-top:8%">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalActivity">
                Điểm danh
            </button>
            <!-- Full Height Modal Right -->
            <div class="modal fade right" id="modalActivity" tabindex="-1" role="dialog" aria-labelledby="modalActivityLabel"
              aria-hidden="true">
              <div class="modal-dialog modal-full-height modal-right" role="document">


                <div class="modal-content">
                  <div class="modal-header">
                    <h4 class="modal-title w-100" id="modalActivityLabel">Điểm danh</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body" id="calender">
                    <ul class="weekcal text-center">
                        <li class="weekend">CN</li>
                        <li class="daily">HAI</li>
                        <li class="daily">BA</li>
                        <li class="daily">TƯ</li>
                        <li class="daily">NĂM</li>
                        <li class="daily">SÁU</li>
                        <li class="weekend">T7</li>
                    </ul>
                    <ul class="weekcal text-center" id="alldateinweek">
                        
                    </ul>
                  </div>
                  <div class="modal-footer justify-content-center">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                  </div>
                </div>
              </div>
            </div>
        </section>
        <#include "footer.ftl">
    </body>
</html>